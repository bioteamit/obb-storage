package com.compilelab.obbstorage.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.compilelab.obbstorage.R;
import com.jana.android.ui.fragment.AbstractFragment;

public class CompressActivityFragment extends AbstractFragment implements View.OnClickListener {

    private EditText edtContentPath;
    private EditText edtPackageName;
    private EditText edtPackageVersion;
    private EditText edtSecureKey;
    private EditText edtCompressPath;

    public CompressActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_compress, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtContentPath = (EditText) view.findViewById(R.id.edt_content_path);
        edtPackageName = (EditText) view.findViewById(R.id.edt_package_name);
        edtPackageVersion = (EditText) view.findViewById(R.id.edt_package_version);
        edtSecureKey = (EditText) view.findViewById(R.id.edt_secure_key);
        edtCompressPath = (EditText) view.findViewById(R.id.edt_obb_path);

        view.findViewById(R.id.btn_compress).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_compress:
                compressToObb();
                break;
        }
    }

    private void compressToObb() {
    }
}
