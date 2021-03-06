package id.xxx.submission.ui.main.tv

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import id.xxx.submission.App
import id.xxx.submission.R
import id.xxx.submission.base.BaseFragment
import id.xxx.submission.base.adapter.ItemClicked
import id.xxx.submission.data.Resource
import id.xxx.submission.data.model.TvResultModel
import id.xxx.submission.databinding.FragmentTvBinding
import id.xxx.submission.ui.detail.DetailActivity
import id.xxx.submission.ui.main.MainViewModel
import id.xxx.submission.viewmodel.ViewModelFactory
import javax.inject.Inject

class TvFragment : BaseFragment<FragmentTvBinding>(), ItemClicked<TvResultModel> {

    @Inject
    internal lateinit var factory: ViewModelFactory

    private lateinit var adapterTv: AdapterTv
    private val viewModel by navGraphViewModels<MainViewModel>(R.id.nav_graph_main) { factory }

    override val layoutFragment: Int = R.layout.fragment_tv

    override fun onAttach(context: Context) {
        (requireActivity().application as App).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapterTv = AdapterTv().apply {
            onItemClicked = this@TvFragment
            binding.tvRecyclerView.setHasFixedSize(true)
            binding.tvRecyclerView.layoutManager = LinearLayoutManager(context)
            binding.tvRecyclerView.adapter = this
        }

        viewModel.tv.observe(viewLifecycleOwner, { handleStat(it) })
    }

    private fun handleStat(resource: Resource<PagedList<TvResultModel>>) {
        when (resource) {
            is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
            is Resource.Empty -> binding.progressBar.visibility = View.GONE
            is Resource.Success -> {
                binding.progressBar.visibility = View.GONE
                resource.data.let { adapterTv.submitList(it) }
            }
            is Resource.Error -> {
                findNavController().getViewModelStoreOwner(R.id.nav_graph_main).viewModelStore.clear()
                binding.progressBar.visibility = View.GONE
                Toast.makeText(requireContext(), resource.errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.by_name -> {
                item.isChecked = true
                viewModel.sorting(MainViewModel.Type.NAME);true
            }
            R.id.by_release -> {
                item.isChecked = true
                viewModel.sorting(MainViewModel.Type.RELEASE_DATA);true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onItemClick(model: TvResultModel) {
        val intent = Intent(requireContext(), DetailActivity::class.java).apply {
            putExtra(DetailActivity.DATA_EXTRA, arrayListOf(R.id.detail_tv, model.id))
        }
        requireActivity().startActivity(intent)
    }
}