package furhatos.app.myfirstskill.flow.main

import furhatos.app.myfirstskill.flow.Parent
import furhatos.flow.kotlin.*

val Greeting : State = state(Parent) {
    onEntry {
        random(
                {   furhat.say("Good Morning and welcome to Robot Customer Support.") },
                {   furhat.say("Hello, my name is Furhat. Welcome to Robot Customer Support.") },
                {   furhat.say("Good Morning and welcome to Robot Customer Support.") }
        )
        goto(CustomerSupport)
    }
}
