package furhatos.app.myfirstskill.nlu

import furhatos.nlu.ComplexEnumEntity
import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.nlu.ListEntity
import furhatos.util.Language

class Product : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("TV", "laptop", "play station", "iPad", "cameras")
    }
}

class IdentifyProblem(val products: ProductList? = null) : Intent () {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@products", "I have a problem with my @products",
                "I bought a @products and it is not working",
                "I ordered a @products through your website and received the wrong reference")
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

class GetCompensation(val compensation: CompensationList? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("Yes, I want @compensation",
                "I will choose @compensation",
                "the @compensation works for me")
    }
}



class ProductList : ListEntity<QuantifiedProduct> ()

class QuantifiedProduct(
        val count : furhatos.nlu.common.Number? =
                furhatos.nlu.common.Number(1),
        val product: Product? = null) : ComplexEnumEntity() {

    override fun getEnum(lang: Language): List<String> {
        return listOf("@count @product", "@product")
    }

    override fun toText(): String {
        return generate("$count $product")
    }
}


// Compensation chosen
class CompensationList : ListEntity<TypeCompensation> ()

class TypeCompensation(
        val compensation: Compensation? = null) : ComplexEnumEntity() {

    override fun getEnum(lang: Language): List<String> {
        return listOf("@compensation")
    }

    override fun toText(): String {
        return generate("$compensation")
    }
}