package scala_pack

import java_pack.UserFactory
import java_pack.Types.{Dot2D, Int}
import scala_pack.BigList

import java.io.{FileWriter, IOException}

object Test_scala {
    @throws[Exception]
    def main(args: Array[String]): Unit = {
        testInt()
        System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n")
        testPoint2D()
        //        System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
//                testTimestampSort();
//                System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
//                testTimestampGetOnPosition();
//                System.out.println("\n\nSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLITSPLIT\n\n");
//                testTimestampInsertOnPosition();
    }

    private def testTimestampInsertOnPosition(): Unit = {
        try {
            val writer = new FileWriter("src/scala_pack/scala_testInsertOnPos.csv", false)
            try {
                var num_elements = 10000
                while (num_elements <= 50000) {
                    val Biglist = new BigList
                    System.out.println("\n-----testTimestampInsertOnPosition-----")
                    for (j <- 0 until 10) {
                        Biglist.push_list(new SmallList)
                        for (i <- 0 until num_elements / 10) {
                            val value = ((Math.random * ((100 - 1) + 1)).toInt + 1) + 1
                            Biglist.push(new Int(value))
                        }
                    }
                    val value = ((Math.random * ((100 - 1) + 1)).toInt + 1) + 1
                    val startTime: Double = System.nanoTime
                    Biglist.insert_item_on_position(value, new Int)
                    val endTime: Double = System.nanoTime
                    val duration: Double = (endTime - startTime) / 1000000
                    System.out.println("----------------------------------")
                    System.out.println("Кол-во элементов: " + num_elements)
                    System.out.println("Время мс: " + duration)
                    System.out.println("----------------------------------")
                    val text = num_elements + "," + duration
                    writer.write(text)
                    writer.append('\n')
                    writer.flush()
                    num_elements += 500
                    Biglist.remove_list()
                }
            } catch {
                case e: IOException =>
                    throw new RuntimeException(e)
            } finally if (writer != null) writer.close()
        }
    }

    private def testTimestampGetOnPosition(): Unit = {
        try {
            val writer = new FileWriter("src/scala_pack/scala_testGetOnPos.csv", false)
            try {
                var num_elements = 10000
                while (num_elements <= 50000) {
                    val Biglist = new BigList
                    System.out.println("\n-----testTimestampGetOnPosition-----")
                    for (j <- 0 until 10) {
                        Biglist.push_list(new SmallList)
                        for (i <- 0 until num_elements / 10) {
                            val value = ((Math.random * ((100 - 1) + 1)).toInt + 1) + 1
                            Biglist.push(new Int(value))
                        }
                    }
                    val value = ((Math.random * ((100 - 1) + 1)).toInt + 1) + 1
                    val startTime: Double = System.nanoTime
                    Biglist.get_item_on_position(value)
                    val endTime: Double = System.nanoTime
                    val duration: Double = (endTime - startTime) / 1000000
                    System.out.println("----------------------------------")
                    System.out.println("Кол-во элементов: " + num_elements)
                    System.out.println("Время мс: " + duration)
                    System.out.println("----------------------------------")
                    val text = num_elements + "," + duration
                    writer.write(text)
                    writer.append('\n')
                    writer.flush()
                    num_elements += 500
                    Biglist.remove_list()
                }
            } catch {
                case e: IOException =>
                    throw new RuntimeException(e)
            } finally if (writer != null) writer.close()
        }
    }

    private def testTimestampSort(): Unit = {
        try {
            val writer = new FileWriter("src/scala_pack/scala_testSort.csv", false)
            try {
                var num_elements = 1000
                while (num_elements <= 20000) {
                    val Biglist = new BigList
                    System.out.println("\n-----testTimestampSort-----")
                    for (j <- 0 until 10) {
                        Biglist.push_list(new SmallList)
                        for (i <- 0 until num_elements / 10) {
                            val value = ((Math.random * ((100 - 1) + 1)).toInt + 1) + 1
                            Biglist.push(new Int(value))
                        }
                    }
                    val startTime: Double = System.nanoTime
                    Biglist.sort_list()
                    val endTime: Double = System.nanoTime
                    val duration: Double = (endTime - startTime) / 1000000
                    System.out.println("----------------------------------")
                    System.out.println("Кол-во элементов: " + num_elements)
                    System.out.println("Время мс: " + duration)
                    System.out.println("----------------------------------")
                    val text = num_elements + "," + duration
                    writer.write(text)
                    writer.append('\n')
                    writer.flush()
                    num_elements += 500
                    Biglist.remove_list()
                }
            } catch {
                case e: IOException =>
                    throw new RuntimeException(e)
            } finally if (writer != null) writer.close()
        }
    }

    @throws[Exception]
    private def testInt(): Unit = {
        System.out.println("+==============+")
        System.out.println("| TEST INTEGER |")
        System.out.println("+==============+")
        val Biglist = new BigList
        System.out.println("\n-----generate data-----")
        for (j <- 0 until 3) {
            Biglist.push_list(new SmallList)
            for (i <- 0 until 3) {
                val value = ((Math.random * ((100 - 1) + 1)).toInt + 1) + 1
                Biglist.push(new Int(value))
            }
        }
        System.out.println(Biglist.print_list)
        System.out.println("\n------pushed list------")
        val value = 777
        Biglist.push(new Int(value))
        Biglist.push(new Int(value))
        Biglist.push(new Int(value))
        Biglist.push(new Int(value))
        System.out.println(Biglist.print_list)
        System.out.println("\n------remove list------")
        Biglist.remove_from_head
        System.out.println(Biglist.print_list)
        System.out.println("\n------remove item from head list------")
        Biglist.remove_item_from_head
        System.out.println(Biglist.print_list)
        System.out.println("\n------pushed in head list------")
        Biglist.push_to_head(new Int(value))
        Biglist.push_to_head(new Int(value))
        Biglist.push_to_head(new Int(value))
        System.out.println(Biglist.print_list)
        System.out.println("\n------insert in position 3, 6, 8 list------")
        Biglist.insert_item_on_position(3, new Int(123))
        Biglist.insert_item_on_position(6, new Int(123))
        Biglist.insert_item_on_position(8, new Int(123))
        System.out.println(Biglist.print_list)
        System.out.println("\n------remove in position 3, 5, 7 list------")
        System.out.println(Biglist.print_list)
        System.out.println("")
        Biglist.remove_item_on_position(3)
        Biglist.remove_item_on_position(5)
        Biglist.remove_item_on_position(7)
        System.out.println(Biglist.print_list)
        System.out.println("\n------get in position list------")
        System.out.println("logical position " + 1 + ": " + Biglist.get_item_on_position(1))
        System.out.println("logical position " + 4 + ": " + Biglist.get_item_on_position(4))
        System.out.println("logical position " + 7 + ": " + Biglist.get_item_on_position(7))
        System.out.println("")
        System.out.println(Biglist.print_list)
        System.out.println("\n------change in position=2 list------")
        System.out.println(Biglist.print_list)
        Biglist.change_item_on_pos(2, new Int(888))
        System.out.println()
        System.out.println(Biglist.print_list)
        System.out.println("\n------balance list (balance column 2)------")
        System.out.println(Biglist.print_list)
        Biglist.balance_list(2)
        System.out.println()
        System.out.println(Biglist.print_list)
        System.out.println("\n------sort list------")
        System.out.println(Biglist.print_list)
        var sorted_list = new BigList
        sorted_list.push_list(Biglist.sort_list)
        System.out.println()
        System.out.println(sorted_list.print_list)
        System.out.println("\n------balance list (balance column 4)------")
        System.out.println(sorted_list.print_list)
        sorted_list.balance_list(4)
        System.out.println()
        System.out.println(sorted_list.print_list)
        System.out.println("\n------Serialization: saving------")
        sorted_list.save_list("src/scala_pack/scala_test_int.txt", UserFactory.get_type_name_list.get(0))
        System.out.println("\n------Serialization: loading------")
        val newBiglist = new BigList
        newBiglist.load_list("src/scala_pack/scala_test_int.txt")
        System.out.println("")
        System.out.println(newBiglist.print_list)
        System.out.println("")
        System.out.println("\n+==================+")
        System.out.println("| END TEST INTEGER |")
        System.out.println("+==================+")
    }

    @throws[Exception]
    private def testPoint2D(): Unit = {
        System.out.println("+==============+")
        System.out.println("| TEST POINT2D |")
        System.out.println("+==============+")
        val Biglist = new BigList
        System.out.println("\n-----generate data-----")
        for (j <- 0 until 3) {
            Biglist.push_list(new SmallList)
            for (i <- 0 until 3) {
                val x = ((Math.random * ((100 - 1) + 1)).toInt + 1) + 1
                val y = ((Math.random * ((100 - 1) + 1)).toInt + 1) + 1
                Biglist.push(new Dot2D(x, y))
            }
        }
        System.out.println(Biglist.print_list)
        System.out.println("\n------pushed list------")
        val x = 77
        val y = 7
        Biglist.push(new Dot2D(x, y))
        Biglist.push(new Dot2D(x, y))
        Biglist.push(new Dot2D(x, y))
        System.out.println(Biglist.print_list)
        System.out.println("\n------remove list------")
        Biglist.remove_from_head
        System.out.println(Biglist.print_list)
        System.out.println("\n------remove item from head list------")
        Biglist.remove_item_from_head
        System.out.println(Biglist.print_list)
        System.out.println("\n------pushed in head list------")
        Biglist.push_to_head(new Dot2D(x, y))
        Biglist.push_to_head(new Dot2D(x, y))
        Biglist.push_to_head(new Dot2D(x, y))
        System.out.println(Biglist.print_list)
        System.out.println("\n------insert in position list------")
        Biglist.insert_item_on_position(3, new Dot2D(123, 321))
        Biglist.insert_item_on_position(8, new Dot2D(123, 321))
        Biglist.insert_item_on_position(6, new Dot2D(123, 321))

        System.out.println(Biglist.print_list)
        System.out.println("\n------remove in position 3, 5, 7 list------")
        Biglist.remove_item_on_position(3)
        Biglist.remove_item_on_position(5)
        Biglist.remove_item_on_position(7)
        System.out.println(Biglist.print_list)
        System.out.println("\n------get in position list------")
        System.out.println("logical position " + 1 + ": " + Biglist.get_item_on_position(1))
        System.out.println("logical position " + 4 + ": " + Biglist.get_item_on_position(4))
        System.out.println("logical position " + 7 + ": " + Biglist.get_item_on_position(7))
        System.out.println("")
        System.out.println(Biglist.print_list)
        System.out.println("\n------change in position=2 list------")
        System.out.println(Biglist.print_list)
        Biglist.change_item_on_pos(2, new Dot2D(88, 8))
        System.out.println()
        System.out.println(Biglist.print_list)
        System.out.println("\n------balance list (balance column 2)------")
        System.out.println(Biglist.print_list)
        Biglist.balance_list(2)
        System.out.println()
        System.out.println(Biglist.print_list)
        System.out.println("\n------sort list------")
        System.out.println(Biglist.print_list)
        var sorted_list = new BigList
        sorted_list.push_list(Biglist.sort_list)
        System.out.println()
        System.out.println(sorted_list.print_list)
        System.out.println("\n------balance list (balance column 4)------")
        System.out.println(sorted_list.print_list)
        sorted_list.balance_list(4)
        System.out.println()
        System.out.println(sorted_list.print_list)
        System.out.println("\n------Serialization: saving------")
        sorted_list.save_list("src/scala_pack/scala_test_point2d.txt", UserFactory.get_type_name_list.get(1))
        System.out.println("\n------Serialization: loading------")
        val newBiglist = new BigList()
        newBiglist.load_list("src/scala_pack/scala_test_point2d.txt")
        System.out.println("")
        System.out.println(newBiglist.print_list)
        System.out.println("")
        System.out.println("\n+==================+")
        System.out.println("| END TEST POINT2D |")
        System.out.println("+==================+")
    }
}
