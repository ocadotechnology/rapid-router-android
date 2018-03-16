package com.codeforlife.rapidrouter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.blockly.android.AbstractBlocklyFragment;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.android.codegen.LoggingCodeGeneratorCallback;
import com.google.blockly.model.DefaultBlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlocklyFragment extends AbstractBlocklyFragment {

    private final CodeGenerationRequest.CodeGeneratorCallback generatorCallback =
            new LoggingCodeGeneratorCallback(getContext(), "LoggingTag");

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
