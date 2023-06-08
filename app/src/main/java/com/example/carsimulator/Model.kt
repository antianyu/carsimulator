package com.example.carsimulator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * 类型
 *
 * @author Tianyu An
 */
class Section(val name: String, val parts: List<Part>)

open class Part(val name: String, var subParts: List<Part>? = null) {

    var showName: String = name

    var damaged by mutableStateOf(false)

    constructor(name: String, vararg partNames: String) : this(name, partNames.map { Part(it) }.toMutableList())

    constructor(name: String, showName: String) : this(name) {
        this.showName = showName
    }

    fun addPart(name: String): Part {
        subParts = subParts.orEmpty() + listOf(Part(name))
        return this
    }

    fun addRubberGaskets(vararg showNames: String): Part {
        subParts = subParts.orEmpty() + showNames.map { RubberGasket(it) }
        return this
    }

    fun addSmallRubberGaskets(vararg showNames: String): Part {
        subParts = subParts.orEmpty() + showNames.map { SmallRubberGasket(it) }
        return this
    }
}

class RubberGasket(showName: String) : Part(name = "橡胶衬套", showName = showName)

class SmallRubberGasket(showName: String) : Part(name = "小橡胶衬套", showName = showName)

class RepeatPart(name: String, vararg showNames: String) : Part(name) {

    init {
        subParts = showNames.map { Part(name = name, showName = it) }
    }
}

class Item(val name: String, val count: Int) {

    var showCount by mutableStateOf(count)
}
