package com.example.buildblitz.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.buildblitz.R
import com.example.buildblitz.databinding.FragmentDetailItemBinding
import com.example.buildblitz.item.Builds

// TODO: Rename parameter arguments, choose names that match



class DetailFavBuildsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentDetailItemBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_fav_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item: Builds? = arguments?.getParcelable("build")

        if (item != null) {
            Log.d("Dani", "Tengo el bundle ")
            binding.personaje.text=getString(R.string.personajeDetalle)+" "+item.personaje
            binding.tvObjeto1.text=getString(R.string.objeto1)+":\n" + item.objeto1
            Glide.with(binding.imagen1.context).load(item.fotoobjeto1).into(binding.imagen1)
            binding.tvObjeto2.text=getString(R.string.objeto2)+":\n"+ item.objeto2
            Glide.with(binding.imagen2.context).load(item.fotoobjeto2).into(binding.imagen2)
            binding.tvObjeto3.text=getString(R.string.objeto3)+":\n "+ item.objeto3
            Glide.with(binding.imagen3.context).load(item.fotoobjeto3).into(binding.imagen3)
            binding.tvObjeto4.text=getString(R.string.objeto4)+":\n"+ item.objeto4
            Glide.with(binding.imagen4.context).load(item.fotoobjeto4).into(binding.imagen4)
            binding.tvObjeto5.text=getString(R.string.objeto5)+":\n"+ item.objeto5
            Glide.with(binding.imagen5.context).load(item.fotoobjeto5).into(binding.imagen5)
            binding.tvObjeto6.text=getString(R.string.objeto6)+":\n"+ item.objeto6
            Glide.with(binding.imagen6.context).load(item.fotoobjeto6).into(binding.imagen6)
        }
    }

    companion object {

            }
    }
