# KotlinSharedPreference
KotlinSharedPreference - Shared preference simple example


Steps for this sample

1.Create Application class 


open class ExampleApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        Preferences.init(this)
    }

}


2.In manifest file define that value


 <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:name=".ExampleApplication"  //this line
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>




3.Create object class

object Preferences {

    private const val NAME = "TestPref"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val EMAIL = Pair("email", "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }


    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var email: String
        get() = preferences.getString(EMAIL.first, EMAIL.second)
        set(value) = preferences.edit {
            it.putString(EMAIL.first, value)
        }

}


4.Access Email data from shared preference


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Insert in to shared preference
        Preferences.email="rameshsambu@gmail.com"

        //Get the data from preference

        println("Email is "+Preferences.email)

    }
}


Thats All...Happy Coding
