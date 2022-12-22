package java_pack;

import java_pack.Types.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class UserFactory {

    public static ArrayList<String> get_type_name_list()
    {
        ArrayList<String> type_list = new ArrayList<>(Arrays.asList("Int", "Dot2D"));
        return type_list;
    }

    public static UserType get_builder_by_name(String type_name)
    {
        switch (type_name)
        {
            case "Int":
                return new Int();
            case "Dot2D":
                return new Dot2D();
            default:
                return null;
        }
    }

    public static int get_comparator(UserType o1, UserType o2)
    {
        if(o1.type_name().contains(o2.type_name())) {

            switch (o1.type_name()) {
                case "Int":
                    return new Int().compare(o1,o2);
                case "Dot2D":
                    return new Dot2D().compare(o1,o2);
                default:
                    return -200;
            }
        }
        return -200;
    }
}
