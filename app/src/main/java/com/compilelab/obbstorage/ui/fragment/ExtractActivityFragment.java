package com.compilelab.obbstorage.ui.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.compilelab.obbstorage.R;
import com.compilelab.obbstorage.obb.ObbExtractor;
import com.jana.android.ui.fragment.AbstractFragment;

public class ExtractActivityFragment extends AbstractFragment implements View.OnClickListener {

    private EditText edtObbPath;
    private EditText edtExtractPath;

    public ExtractActivityFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_extract, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtObbPath = (EditText) view.findViewById(R.id.edt_obb_path);
        edtExtractPath = (EditText) view.findViewById(R.id.edt_extract_path);

        view.findViewById(R.id.btn_extract).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_extract:
                extractObb();
                break;
        }
    }

    private void extractObb() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                String obbPath = Environment.getExternalStorageDirectory().getPath() + getString
                        (R.string.path_obb_dir) + "com.compilelab.obbstorage/" + "main.2.com.compilelab.obbstorage.obb";
                String extractionPath = Environment.getExternalStorageDirectory().getPath() + getString(R.string.path_extract_dir) + "2";

                ObbExtractor extractor = new ObbExtractor(obbPath, null, extractionPath, true);
                extractor.extract();

                return null;
            }
        }.execute();
    }
}
