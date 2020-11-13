package bstorm.akim.correctionExo3.exception;

import lombok.Getter;

@Getter
public abstract class ElementNotFoundException extends Exception {

    private final Object id;
    private final Class<?> clazz;

    public ElementNotFoundException( Class<?> ofClass, Object id  ) {
        super("L'element de classe "+ ofClass.getSimpleName() +" d'id("+id+") n'a pas été trouvé");
        this.id = id;
        this.clazz = ofClass;
    }
}
