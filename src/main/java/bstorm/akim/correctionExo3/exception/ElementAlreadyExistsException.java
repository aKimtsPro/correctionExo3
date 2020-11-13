package bstorm.akim.correctionExo3.exception;

import lombok.Getter;

@Getter
public abstract class ElementAlreadyExistsException extends Exception {

    private final int id;
    private final Class<?> clazz;

    public ElementAlreadyExistsException( int id, Class<?> clazz) {
        super("L'element que vous voulez créer existe deja " +
                "\n\t-classe: " + clazz.getSimpleName() + " ;" +
                "\n\t-id : " + id + " ;");
        this.id = id;
        this.clazz = clazz;
    }
}
