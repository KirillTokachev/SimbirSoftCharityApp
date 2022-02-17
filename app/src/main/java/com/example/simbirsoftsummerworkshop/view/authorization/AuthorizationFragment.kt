package com.example.simbirsoftsummerworkshop.view.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simbirsoftsummerworkshop.R
import com.example.simbirsoftsummerworkshop.databinding.FragmentAuthorizationBinding
import com.example.simbirsoftsummerworkshop.view.fragments.BaseFragment
import com.jakewharton.rxbinding4.widget.textChangeEvents
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_authorization.*

const val MIN_SYMBOLS = 5

class AuthorizationFragment : BaseFragment() {
    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
    }

    private fun setUpView() {
        Observable.combineLatest(
            text_input_edit_text_email.textChangeEvents(),
            text_input_edit_text_password.textChangeEvents(),
            BiFunction { t1, t2 ->
                t1.view.text.length > MIN_SYMBOLS && t2.view.text.length > MIN_SYMBOLS
            }
        ).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                button_authorization.isEnabled = it
            }

        button_authorization.setOnClickListener {
            findNavController().navigate(R.id.action_authorizationFragment_to_helpFragment)
        }
    }
}
