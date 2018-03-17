package com.codeforlife.rapidrouter

import com.google.blockly.android.AbstractBlocklyFragment
import com.google.blockly.android.codegen.CodeGenerationRequest
import com.google.blockly.android.codegen.LoggingCodeGeneratorCallback
import com.google.blockly.model.DefaultBlocks
import java.util.Collections.emptyList

class BlocklyFragment : AbstractBlocklyFragment() {

    private val generatorCallback = LoggingCodeGeneratorCallback(context, "LoggingTag")

    override fun getToolboxContentsXmlPath(): String {
        return "toolbox/toolbox37.xml"
    }

    override fun getBlockDefinitionsJsonPaths(): List<String> {
        val assetPaths = ArrayList(DefaultBlocks.getAllBlockDefinitions())
        assetPaths.add("blocks/CustomBlocks.json")
        return assetPaths
    }

    override fun getGeneratorsJsPaths(): List<String> {
        return emptyList<String>()
    }

    override fun getCodeGenerationCallback(): CodeGenerationRequest.CodeGeneratorCallback {
        return generatorCallback
    }
}
