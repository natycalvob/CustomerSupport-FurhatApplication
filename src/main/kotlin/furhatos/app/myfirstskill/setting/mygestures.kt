package furhatos.app.myfirstskill.setting

import furhatos.gestures.BasicParams
import furhatos.gestures.defineGesture
import furhatos.gestures.ARKitParams


val MySmile = defineGesture("MySmile") {
    frame(0.32, 0.72) {
        BasicParams.EXPR_SAD to 0.5
        ARKitParams.JAW_OPEN to 0.5
    }
    frame(0.2, 0.72){
        ARKitParams.BROW_INNER_UP to 1.0
        ARKitParams.BROW_DOWN_RIGHT to 0.5
    }
    frame(0.16, 0.72){
        ARKitParams.EYE_BLINK_LEFT to 0.1
        ARKitParams.EYE_BLINK_RIGHT to 0.1
    }
    reset(1.04)
}


