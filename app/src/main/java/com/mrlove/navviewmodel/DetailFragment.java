package com.mrlove.navviewmodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.mrlove.navviewmodel.databinding.FragmentDetailBinding;


public class DetailFragment extends Fragment {
    FragmentDetailBinding binding;
    MyViewModel mViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false);
        mViewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        binding.setData(mViewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_detailFragment2_to_masterFragment);
            }
        });

        return binding.getRoot();
    }

}
