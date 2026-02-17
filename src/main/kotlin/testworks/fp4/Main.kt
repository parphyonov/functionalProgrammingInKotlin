package testworks.fp4

fun main() {
    val cProc = ClickProcessor()

    setupClickListeners(cProc)

    println(cProc.processClick("button1"))
    println(cProc.processClick("button2"))
    println(cProc.processClick("button3"))
    println(cProc.processClick("button4"))
}

interface ClickListener {
    fun onClick(elementId: String): String
}

class ClickProcessor {
    private val _clickListeners = mutableMapOf<String, ClickListener>()
    val clickListeners
        get() = _clickListeners.toMap()

    fun registerClickListener(elementId: String, listener: ClickListener) {
        _clickListeners[elementId] = listener
    }

    fun processClick(elementId: String): String {
        val listener = _clickListeners[elementId]
        return listener?.onClick(elementId) ?: "No listener registered for $elementId"
    }
}

fun setupClickListeners(clickProcessor: ClickProcessor) {
    clickProcessor.registerClickListener("button1", object : ClickListener {
        override fun onClick(elementId: String): String = "${formatButtonName(elementId)} clicked!"
    })

    clickProcessor.registerClickListener("button2", object : ClickListener {
        override fun onClick(elementId: String): String = "${formatButtonName(elementId)} clicked!"
    })

    clickProcessor.registerClickListener("button3", object : ClickListener {
        override fun onClick(elementId: String): String = "${formatButtonName(elementId)} clicked!"
    })
}

fun formatButtonName(input: String): String {
    val firstDigitIndex = input.indexOfFirst { it.isDigit() }
    if (firstDigitIndex == -1) return input.replaceFirstChar { it.uppercase() }

    val textPart = input.substring(0, firstDigitIndex).replaceFirstChar { it.uppercase() }
    val numberPart = input.substring(firstDigitIndex)

    return "$textPart $numberPart"
}