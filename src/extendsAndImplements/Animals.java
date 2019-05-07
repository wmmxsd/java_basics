package extendsAndImplements;

import java.io.Serializable;

//在interface之间也可以声明为extends（多继承）的关系
public interface Animals extends Runner, Serializable {
    void breathe();
}
