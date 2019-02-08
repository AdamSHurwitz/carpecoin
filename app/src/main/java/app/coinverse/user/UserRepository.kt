package app.coinverse.user

import app.coinverse.firebase.USERS_DOCUMENT
import app.coinverse.utils.DELETE_USER_FUNCTION
import app.coinverse.utils.PATH_FUNCTION_PARAM
import app.coinverse.utils.USER_ID_FUNCTION_PARAM
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.functions.FirebaseFunctions

class UserRepository {
    private val LOG_TAG = UserRepository::class.java.simpleName
    private var functions: FirebaseFunctions

    init {
        functions = FirebaseFunctions.getInstance()
    }

    fun deleteUser(user: FirebaseUser) = functions.getHttpsCallable(DELETE_USER_FUNCTION)
            .call(hashMapOf(
                    USER_ID_FUNCTION_PARAM to user.uid,
                    PATH_FUNCTION_PARAM to "$USERS_DOCUMENT${user.uid}"))
            .continueWith { task -> (task.result?.data as HashMap<String, String>) }

}