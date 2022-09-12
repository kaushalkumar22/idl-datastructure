package a_util;

import java.util.HashMap;
import java.util.Objects;

public class TestHashCode {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestHashCode that = (TestHashCode) o;
        return id == that.id && (name == that.name) || (that.name != null &&that.name .equals(name));
    }

    @Override
    public int hashCode() {
        if(this==null) return 0;
        Object[] objects = {id,name};
        int result =1;
        for (Object obj :objects){
            result = 31*result+(obj==null?0:obj.hashCode());
        }
        return result;
    }

}
