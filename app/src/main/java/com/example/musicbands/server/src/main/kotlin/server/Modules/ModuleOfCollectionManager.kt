//package server.Modules
//
//import com.example.musicbands.client.managers.InputData
//import dev.shustoff.dikt.Create
//import dev.shustoff.dikt.CreateSingle
//import dev.shustoff.dikt.ProvideSingle
//import dev.shustoff.dikt.UseModules
//import com.example.musicbands.server.src.main.kotlin.server.Database.PostgresDao
//import com.example.musicbands.server.src.main.kotlin.server.Managers.CollectionManager
//
//@UseModules(ModuleOfPostgresDao::class)
//class ModuleOfCollectionManager(private val moduleOfPostgresDao: ModuleOfPostgresDao) {
//
//
//    @CreateSingle
//    private fun inputData() : InputData
//
//    @Create
//    fun collectionManager() : CollectionManager
//
//    @ProvideSingle
//    private fun postgresDao() : PostgresDao
//
//
//
//
//
//}
//
