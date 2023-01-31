import java.io.File

object Config {

    val BLACK_LIST: HashSet<String> = hashSetOf()

    private var isFirst = true

    fun checkFile() {

        val cfgName = "ServerModsInjector.cfg"

        val file = File(cfgName)

        try {
            BLACK_LIST.clear()
            BLACK_LIST += file.readLines()

        } catch(e: Exception) {
            if (isFirst) {
                file.createNewFile()
                isFirst = false
                return checkFile()
            }
            e.printStackTrace()
        }
    }
}