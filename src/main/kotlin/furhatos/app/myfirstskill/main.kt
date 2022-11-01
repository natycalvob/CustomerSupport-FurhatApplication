package furhatos.app.myfirstskill

import furhatos.app.myfirstskill.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class MyfirstskillSkill : Skill() {
    override fun start() {
        // Initial State Idle
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}


