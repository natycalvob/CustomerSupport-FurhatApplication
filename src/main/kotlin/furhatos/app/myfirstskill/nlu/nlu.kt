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
class Compensation : EnumEntity(stemming = true, speechRecPhrases = true ) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("25% discount in new products",
        "A gift card of 1500 SEK",
        "A new tablet of the brand ABC-Tec")
    }
}

class Refund : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf( " I want my money back",
        "Refund of the total price",
        "I would like a refund")
    }
}
class CompensationOption: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(" What compensation plans do you have?",
        "Do you have other alternative for compensation?",
        "I don't think the options you offer are suitable for my case",
        "What about getting a different product?")
    }
}