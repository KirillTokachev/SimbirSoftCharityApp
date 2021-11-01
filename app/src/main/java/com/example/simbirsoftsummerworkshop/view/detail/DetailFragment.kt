package com.example.simbirsoftsummerworkshop.view.detail

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.simbirsoftsummerworkshop.databinding.FragmentDetailNewsBinding
import com.example.simbirsoftsummerworkshop.utils.Util.getTime
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.example.simbirsoftsummerworkshop.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_detail_news.*

class DetailFragment : BaseFragment<FragmentDetailNewsBinding>() {
    private val viewModel: NewsViewModel by activityViewModels()

    override fun getViewBinding() = FragmentDetailNewsBinding.inflate(layoutInflater)

    override fun setUpViews() {
        setUpButton()
        setUpDetail()
    }

    private fun setUpButton() {
        toolbar_detail.setNavigationOnClickListener { findNavController().popBackStack() }
    }

    private fun setUpDetail() {
        viewModel.detailNews.observe(viewLifecycleOwner) {
            title_detail_text.text = it.name
            detail_news_title.text = it.name
            date_detail_text.text = getTime(it)
            organization_name_company.text = it.company
            organization_address_text.text = it.address
            organization_phone_text.text = it.phone
            news_description_text.text = it.fullDescription
        }
    }
}
