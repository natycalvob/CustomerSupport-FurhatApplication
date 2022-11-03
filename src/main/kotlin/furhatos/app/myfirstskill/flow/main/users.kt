package furhatos.app.myfirstskill.flow.main

import furhatos.app.myfirstskill.nlu.CompensationList
import furhatos.app.myfirstskill.nlu.ProductList
import furhatos.records.User

class ProductData (
        var products : ProductList = ProductList()
)

class CompensationData (
        var compensation: CompensationList = CompensationList()
)

val User.productproblem : ProductData
    get() = data.getOrPut(ProductData::class.qualifiedName, ProductData())


val User.chosencompensation : CompensationData
    get() = data.getOrPut(CompensationData::class.qualifiedName, CompensationData())