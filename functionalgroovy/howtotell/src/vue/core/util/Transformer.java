package vue.core.util;


public interface Transformer<T, U> {

    U transform(T input); 
}
