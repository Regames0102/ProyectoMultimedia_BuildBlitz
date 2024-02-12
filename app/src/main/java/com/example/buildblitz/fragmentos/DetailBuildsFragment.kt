package com.example.buildblitz.fragmentos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.buildblitz.databinding.FragmentDetailItemBinding
import com.example.buildblitz.item.Builds


@Suppress("DEPRECATION")
class DetailBuildsFragment : Fragment() {
    private lateinit var binding: FragmentDetailItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item: Builds? = arguments?.getParcelable("build")

        if (item != null) {
            Log.d("Dani", "Tengo el bundle ")
            binding.personaje.text="Build de: "+item.personaje
            binding.tvObjeto1.text="Objeto 1: \n"+ item.objeto1
            Glide.with(binding.imagen1.context).load(item.fotoobjeto1).into(binding.imagen1)
            binding.tvObjeto2.text="Objeto 2: \n"+ item.objeto2
            Glide.with(binding.imagen2.context).load(item.fotoobjeto2).into(binding.imagen2)
            binding.tvObjeto3.text="Objeto 3:\n "+ item.objeto3
            Glide.with(binding.imagen3.context).load(item.fotoobjeto3).into(binding.imagen3)
            binding.tvObjeto4.text="Objeto 4: \n"+ item.objeto4
            Glide.with(binding.imagen4.context).load(item.fotoobjeto4).into(binding.imagen4)
            binding.tvObjeto5.text="Objeto 5: \n"+ item.objeto5
            Glide.with(binding.imagen5.context).load(item.fotoobjeto5).into(binding.imagen5)
            binding.tvObjeto6.text="Objeto 6: \n"+ item.objeto6
            Glide.with(binding.imagen6.context).load(item.fotoobjeto6).into(binding.imagen6)
        }
    }
}