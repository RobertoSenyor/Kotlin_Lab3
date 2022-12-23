package kotlin_pack

import java_pack.Serializator
import java_pack.Types.Dot2D
import java_pack.Types.Int
import java_pack.UserFactory
import java.io.FileWriter
import java.io.IOException


object Test_kotlin {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
//        testInt()
//        println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n")
//        testPoint2D()
//        System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
        testTimestampSort();
//        System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
//        testTimestampGetOnPosition();
//        System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
//        testTimestampInsertOnPosition();
    }

    private fun testTimestampInsertOnPosition() {
        try {
            FileWriter("src/kotlin_pack/testInsertOnPos.csv", false).use { writer ->
                var num_elements = 10000
                while (num_elements <= 500000) {
                    val Biglist = BigList()
                    println("\n-----testTimestampInsertOnPosition-----")
                    for (j in 0..9) {
                        Biglist.push(SmallList())
                        for (i in 0 until num_elements / 10) {
                            val value = (Math.random() * (100 - 1 + 1)).toInt() + 1 + 1
                            Biglist.push(Int(value))
                        }
                    }
                    val value = (Math.random() * (100 - 1 + 1)).toInt() + 1 + 1
                    val startTime = System.nanoTime().toDouble()
                    Biglist.insert_item_on_position(value, Int())
                    val endTime = System.nanoTime().toDouble()
                    val duration = (endTime - startTime) / 1000000
                    println("----------------------------------")
                    println("Кол-во элементов: $num_elements")
                    println("Время мс: $duration")
                    println("----------------------------------")
                    val text = "$num_elements,$duration"
                    writer.write(text)
                    writer.append('\n')
                    writer.flush()
                    num_elements += 10000
                    Biglist.remove_list()
                }
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    private fun testTimestampGetOnPosition() {
        try {
            FileWriter("src/kotlin_pack/testGetOnPos.csv", false).use { writer ->
                var num_elements = 10000
                while (num_elements <= 500000) {
                    val Biglist = BigList()
                    println("\n-----testTimestampGetOnPosition-----")
                    for (j in 0..9) {
                        Biglist.push(SmallList())
                        for (i in 0 until num_elements / 10) {
                            val value = (Math.random() * (100 - 1 + 1)).toInt() + 1 + 1
                            Biglist.push(Int(value))
                        }
                    }
                    val value = (Math.random() * (100 - 1 + 1)).toInt() + 1 + 1
                    val startTime = System.nanoTime().toDouble()
                    Biglist.get_item_on_position(value)
                    val endTime = System.nanoTime().toDouble()
                    val duration = (endTime - startTime) / 1000000
                    println("----------------------------------")
                    println("Кол-во элементов: $num_elements")
                    println("Время мс: $duration")
                    println("----------------------------------")
                    val text = "$num_elements,$duration"
                    writer.write(text)
                    writer.append('\n')
                    writer.flush()
                    num_elements += 10000
                    Biglist.remove_list()
                }
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    private fun testTimestampSort() {
        try {
            FileWriter("src/kotlin_pack/testSort.csv", false).use { writer ->
                var num_elements = 1000
                while (num_elements <= 500000) {
                    val Biglist = BigList()
                    println("\n-----testTimestampSort-----")
                    for (j in 0..9) {
                        Biglist.push(SmallList())
                        for (i in 0 until num_elements / 10) {
                            val value = (Math.random() * (100 - 1 + 1)).toInt() + 1 + 1
                            Biglist.push(Int(value))
                        }
                    }
                    val startTime = System.nanoTime().toDouble()
                    Biglist.sort_list()
                    val endTime = System.nanoTime().toDouble()
                    val duration = (endTime - startTime) / 1000000
                    println("----------------------------------")
                    println("Кол-во элементов: $num_elements")
                    println("Время мс: $duration")
                    println("----------------------------------")
                    val text = "$num_elements,$duration"
                    writer.write(text)
                    writer.append('\n')
                    writer.flush()
                    num_elements += 1000
                    Biglist.remove_list()
                }
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    @Throws(Exception::class)
    private fun testInt() {
        println("+==============+")
        println("| TEST INTEGER |")
        println("+==============+")
        val Biglist = BigList()
        println("\n-----generate data-----")
        for (j in 0..2) {
            Biglist.push(SmallList())
            for (i in 0..2) {
                val value = (Math.random() * (100 - 1 + 1)).toInt() + 1 + 1
                Biglist.push(Int(value))
            }
        }
        println(Biglist.print_list())
        println("\n------pushed list------")
        val value = 777
        Biglist.push(Int(value))
        Biglist.push(Int(value))
        Biglist.push(Int(value))
        println(Biglist.print_list())
        println("\n------remove list------")
        Biglist.remove_from_head()
        println(Biglist.print_list())
        println("\n------remove item from head list------")
        Biglist.remove_item_from_head()
        println(Biglist.print_list())
        println("\n------pushed in head list------")
        Biglist.push_to_head(Int(value))
        Biglist.push_to_head(Int(value))
        Biglist.push_to_head(Int(value))
        println(Biglist.print_list())
        println("\n------insert in position list------")
        Biglist.insert_item_on_position(3, Int(123))
        Biglist.insert_item_on_position(6, Int(123))
        Biglist.insert_item_on_position(8, Int(123))
        println(Biglist.print_list())
        println("\n------remove in position 3, 5, 7 list------")
        println(Biglist.print_list())
        println("")
        Biglist.remove_item_on_position(3)
        Biglist.remove_item_on_position(5)
        Biglist.remove_item_on_position(7)
        println(Biglist.print_list())
        println("\n------get in position list------")
        println("logical position " + 1 + ": " + Biglist.get_item_on_position(1))
        println("logical position " + 4 + ": " + Biglist.get_item_on_position(4))
        println("logical position " + 7 + ": " + Biglist.get_item_on_position(7))
        println("")
        println(Biglist.print_list())
        println("\n------change in position=2 list------")
        println(Biglist.print_list())
        Biglist.change_item_on_pos(2, Int(888))
        println()
        println(Biglist.print_list())
        println("\n------balance list (balance column 2)------")
        println(Biglist.print_list())
        Biglist.balance_list(2)
        println()
        println(Biglist.print_list())
        println("\n------sort list------")
        println(Biglist.print_list())
        var sorted_list = Biglist.sort_list()
        println()
        println(sorted_list.print_list())
        println("\n------balance list (balance column 4)------")
        println(sorted_list.print_list())
        sorted_list.balance_list(4)
        println()
        println(sorted_list.print_list())
        println("\n------Serialization: saving------")
        sorted_list.save_list("src/kotlin_pack/test_int.txt", UserFactory.get_type_name_list()[0])
        println("\n------Serialization: loading------")
        val newBiglist = Biglist
        newBiglist.load_list("src/kotlin_pack/test_int.txt")
        println("")
        newBiglist.forEach { obj: Any? -> print(obj) }
        println("")
        println("\n+==================+")
        println("| END TEST INTEGER |")
        println("+==================+")
    }

    @Throws(Exception::class)
    private fun testPoint2D() {
        println("+==============+")
        println("| TEST POINT2D |")
        println("+==============+")
        val Biglist = BigList()
        println("\n-----generate data-----")
        for (j in 0..2) {
            Biglist.push(SmallList())
            for (i in 0..2) {
                val x = (Math.random() * (100 - 1 + 1)).toInt() + 1 + 1
                val y = (Math.random() * (100 - 1 + 1)).toInt() + 1 + 1
                Biglist.push(Dot2D(x, y))
            }
        }
        println(Biglist.print_list())
        println("\n------pushed list------")
        val x = 77
        val y = 7
        Biglist.push(Dot2D(x, y))
        Biglist.push(Dot2D(x, y))
        Biglist.push(Dot2D(x, y))
        println(Biglist.print_list())
        println("\n------remove list------")
        Biglist.remove_from_head()
        println(Biglist.print_list())
        println("\n------remove item from head list------")
        Biglist.remove_item_from_head()
        println(Biglist.print_list())
        println("\n------pushed in head list------")
        Biglist.push_to_head(Dot2D(x, y))
        Biglist.push_to_head(Dot2D(x, y))
        Biglist.push_to_head(Dot2D(x, y))
        println(Biglist.print_list())
        println("\n------insert in position list------")
        Biglist.insert_item_on_position(3, Dot2D(123, 321))
        Biglist.insert_item_on_position(8, Dot2D(123, 321))
        Biglist.insert_item_on_position(6, Dot2D(123, 321))
        println(Biglist.print_list())
        println("\n------remove in position 3, 5, 7 list------")
        Biglist.remove_item_on_position(3)
        Biglist.remove_item_on_position(5)
        Biglist.remove_item_on_position(7)
        println(Biglist.print_list())
        println("\n------get in position list------")
        println("logical position " + 1 + ": " + Biglist.get_item_on_position(1))
        println("logical position " + 4 + ": " + Biglist.get_item_on_position(4))
        println("logical position " + 7 + ": " + Biglist.get_item_on_position(7))
        println("")
        println(Biglist.print_list())
        println("\n------change in position=2 list------")
        println(Biglist.print_list())
        Biglist.change_item_on_pos(2, Dot2D(88, 8))
        println()
        println(Biglist.print_list())
        println("\n------balance list (balance column 2)------")
        println(Biglist.print_list())
        Biglist.balance_list(2)
        println()
        println(Biglist.print_list())
        println("\n------sort list------")
        println(Biglist.print_list())
        var sorted_list = Biglist.sort_list()
        println()
        println(sorted_list.print_list())
        println("\n------balance list (balance column 4)------")
        println(sorted_list.print_list())
        sorted_list.balance_list(4)
        println()
        println(sorted_list.print_list())
        println("\n------Serialization: saving------")
        sorted_list.save_list("src/kotlin_pack/test_point2d.csv", UserFactory.get_type_name_list()[1])
        println("\n------Serialization: loading------")
        val newBiglist = Biglist
        newBiglist.load_list("src/kotlin_pack/test_point2d.csv")
        println("")
        newBiglist.forEach { obj: Any? -> print(obj) }
        println("")
        println("\n+==================+")
        println("| END TEST POINT2D |")
        println("+==================+")
    }
}
