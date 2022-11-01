package furhatos.app.myfirstskill.flow

import furhatos.app.myfirstskill.flow.main.Idle
import furhatos.app.myfirstskill.setting.distanceToEngage
import furhatos.app.myfirstskill.setting.maxNumberOfUsers
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.Voice

val Init : State = state() {
    init {
        /** Set our default interaction parameters */
        users.setSimpleEngagementPolicy(distanceToEngage, maxNumberOfUsers)
        furhat.voice = Voice("Matthew")
        /** start the interaction */
        goto(Idle)
    }
}
