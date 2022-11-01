package furhatos.app.myfirstskill.nlu

import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

class Product : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("TV", "laptop", "play station", "ipad")
    }
}

class IdentifyProblem(val product: Product? = null) : Intent () {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@product", "I have a problem with my @product", "I bought a @product and it is not working",
        "I ordered a @product through your website and received the wrong reference")
    }
}

class Reference : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("101", "201", "301", "401")
    }
}

class OrderNumber(val reference: Reference? = null) : Intent () {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes, my order is @reference", "@reference", "the number is @reference")
    }
}