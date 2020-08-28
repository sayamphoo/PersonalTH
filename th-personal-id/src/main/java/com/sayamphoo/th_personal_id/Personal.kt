package com.sayamphoo.th_personal_id

class Personal {
    fun checkPersonalTH(idPersonal: String): Reply {
        var mPersonalId: Long = 0
        var mPropriety = false
        var mCode = ""
        var mMessage = ""

        if (idPersonal.length == 13) {
            try {
                mPersonalId = idPersonal.toLong()
                if (mPersonalId.toString().length == 13) {
                    mPropriety = true
                }
            } catch (e: Exception) {
                mPropriety = false
                mCode = "403"
                mMessage = "Id Not correct!!"
            }
        } else {
            mPropriety = false
            mCode = "403"
            mMessage = "Not enough length!!"
        }

        if (mPropriety) {
            mPropriety = Analyze(mPersonalId)

            if (mPropriety) {
                mMessage = "CodeIsCorrect!!"
                mCode = "200"
            } else {
                mCode = "403"
                mMessage = "Id Not correct!!"
            }

        } else {
            mPropriety = false
        }

        return setReplyCreate(mPropriety, mCode, mMessage)
    }

    private fun Analyze(id: Long): Boolean {
        var mId: Long? = id
        var mBase = 1000000000000L
        var mMain = 0
        var mPositiveResult = 0
        var mCorrectness = false

        for (i in 13 downTo 2) {

            if (mId != null) {
                mMain = (mId / mBase).toInt()
                mPositiveResult += (mMain * i)
                mId = (mId % mBase)
                mBase = (mBase / 10)
            } else {
                break
            }
        }

        if ((11 - (mPositiveResult % 11)) == mId!!.toInt()) {
            mCorrectness = true
        }

        return mCorrectness
    }

    private fun setReplyCreate(p: Boolean, c: String, m: String): Reply {
        return Reply(p, c, m)
    }
}