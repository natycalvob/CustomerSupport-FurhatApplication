package furhatos.app.myfirstskill.flow.main

import furhatos.app.myfirstskill.nlu.ProductList
import furhatos.records.User

class ProductData (
        var products : ProductList = ProductList()
)

val User.productproblem : ProductData
    get() = data.getOrPut(ProductData::class.qualifiedName, ProductData())