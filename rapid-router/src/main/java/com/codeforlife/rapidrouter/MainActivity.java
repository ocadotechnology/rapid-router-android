package com.codeforlife.rapidrouter;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.android.codegen.LoggingCodeGeneratorCallback;
import com.google.blockly.model.DefaultBlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AbstractBlocklyActivity {
    private final CodeGenerationRequest.CodeGeneratorCallback generatorCallback =
            new LoggingCodeGeneratorCallback(this, "LoggingTag");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View onCreateContentView(int parentId) {
        return getLayoutInflater().inflate(R.layout.layout, null);
    }

    @NonNull
    @Override
    protected String getToolboxContentsXmlPath() {
        return "toolbox/toolbox37.xml";
    }

    @NonNull
    @Override
    protected List<String> getBlockDefinitionsJsonPaths() {
        final ArrayList<String> assetPaths = new ArrayList<>(DefaultBlocks.getAllBlockDefinitions());
        assetPaths.add("blocks/CustomBlocks.json");
        return assetPaths;
    }

    @NonNull
    @Override
    protected List<String> getGeneratorsJsPaths() {
        return Collections.emptyList();
    }

    @NonNull
    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {
        return generatorCallback;
    }
}
