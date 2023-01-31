import java.io.File

object Injector {

    private val SERVER_FILE_FOLDER = File("SERVER")
    private const val MINECRAFT_VERSION = "1.7.10"

    fun parseAndCopyCfg() {
        println("MODS -> START")
        val pathCfg = ".minecraft/config"
        val fileCfg = File(pathCfg)
        val serverCfg = File(SERVER_FILE_FOLDER, "config")
        fileCfg.copyRecursively(serverCfg)
        println("CONFIGS -> DONE")
    }

    fun parseAndCopyScripts() {
        println("MODS -> START")
        val pathScripts = ".minecraft/scripts"
        val fileScripts = File(pathScripts)
        val serverScripts = File(SERVER_FILE_FOLDER, "scripts")
        fileScripts.copyRecursively(serverScripts)
        println("SCRIPTS -> DONE")
    }

    fun parseAndCopyMods() {
        println("MODS -> START")

        val serverModsFile = File(SERVER_FILE_FOLDER, "mods")
        serverModsFile.mkdirs()

        val commonModsFile = File(".minecraft/mods")
        if (commonModsFile.isDirectory) {
            commonModsFile.copyRecursively(serverModsFile)
        }
        println("MODS -> DONE")
    }

    fun removeClientMods() {
        println("REMOVE CLIENT MODS -> START")
        val serverModsFile = File(SERVER_FILE_FOLDER, "mods")
        if (serverModsFile.isDirectory) {

            val versionFile = File(serverModsFile, MINECRAFT_VERSION)
            if (versionFile.isDirectory) {

                Config.BLACK_LIST.forEach { black ->
                    versionFile.listFiles()
                        ?.filter { it.name.contains(black) }
                        ?.forEach(File::delete)
                }
            }
            Config.BLACK_LIST.forEach { black ->
                serverModsFile.listFiles()
                    ?.filter { it.name.contains(black) }
                    ?.forEach(File::delete)
            }
        }
        println("REMOVE CLIENT MODS -> DONE")
    }

    fun parseMods() {
        val commonModsFile = File("mods")
        if (commonModsFile.isDirectory) {

            val modsFileList = File("mods.txt")
            modsFileList.createNewFile()

            val list = mutableListOf<String>()
            commonModsFile.listFiles()?.forEach {
                if (it.isFile) list += it.name
                println("MOD -> ${it.name}")
            }
            modsFileList.writeText(list.joinToString("\n"))
        }
    }

    fun getClient() {
        val common = File("common.txt")
        val commonMods =  common.readLines()

        val server = File("server.txt")
        val serverMods =  server.readLines()

        val modsFileList = File("mods.txt")
        modsFileList.createNewFile()

        val list = mutableListOf<String>()

        commonMods.filter { !serverMods.contains(it) }.forEach {
            list += it
            println("CLIENT MOD -> $it")
        }
        modsFileList.writeText(list.joinToString("\n"))
    }
}