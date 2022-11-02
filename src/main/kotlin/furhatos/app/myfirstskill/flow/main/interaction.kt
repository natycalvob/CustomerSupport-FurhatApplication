package furhatos.app.myfirstskill.flow.main

import furhatos.flow.kotlin.*
import furhatos.nlu.common.*
import furhatos.app.myfirstskill.nlu.*
import furhatos.gestures.Gestures
import furhatos.records.Location

val CustomerSupport = state {
    onEntry {
        random(
                {   furhat.ask("Do you need some assistance?") },
                {   furhat.ask("Do you need some customer support?") },
                {   furhat.ask("How can I help you today?")}
        )
    }

    onResponse<Yes> {
        furhat.ask("How can I help you today?")
    }

    onResponse<No> {
        furhat.say("This is customer support. I suggest you approach the information desk.")
        furhat.say("Have a splendid day!")
        goto(Idle)
    }

    onResponse<IdentifyProblem> {
        val products = it.intent.products
        if (products != null) {
            furhat.say("I understand that you have an issue with your ${products.text}, Let me check!")
            products.list.forEach {
                users.current.productproblem.products.list.add(it)
            }
        }
        furhat.ask("Do you have a reference number of your order?")
    }

    onResponse<OrderNumber> {
        furhat.say {
            +"Thank you. I confirm the order is ${it.intent.reference}. "
            +"Please wait a few minutes while I check our database."
            +delay(5000)
            +blocking {
                furhat.gesture(Gestures.CloseEyes)
                furhat.gesture(Gestures.Shake, async = false)
                furhat.gesture(Gestures.OpenEyes)
            }
            +"I observed that you ordered the TV-1."
            +"Unfortunately, this reference is out of stock. Indeed, you mistakenly received the TV-2."
            +"On behalf of our company, I apologize for the inconvenience."
            +delay(500)
        }
        furhat.say(" To compensate our customers, we offer two solutions. You could proceed with " +
                "a new order for either TV-2 or TV-3 with a 20% discount. The second solution is to keep " +
                "the current order which has a waiting time of 6 weeks, and we offer a 30% discount on the " +
                "total price of the item.")
        furhat.ask("Does any of this alternatives work for you?")
    }

    onResponse<Refund> {
        furhat.say("Okay, the company understands your decision. We will proceed with the refund of the " +
                "total amount you paid for the initial order.")
        furhat.ask(" Is there anything else I can help you with?")
    }

    onResponse<CompensationOption> {
        furhat.say("We have ${Compensation().optionsToText()}")
        furhat.ask("Does any of this alternatives work for you?")
    }
}