package br.com.staroski.rules;
import java.util.Collection;

/**
 * Interface que representa a especifica&ccedil;�o de uma regra para determinado tipo de dado.<BR>
 * A especifica&ccedil;�o pode fornecer detalhes sobre o motivo de um objeto atende-la ou n�o.<BR>
 * O crit&eacute;rio pra avaliar se um objeto atende ou n�o a uma especifica&ccedil;�o &eacute; realizado atrav&eacute;s da implementa&ccedil;�o do m&eacute;todo
 * {@link #isSatisfiedBy(Object, Collection)}.<BR>
 * <BR>
 * <I><B>Dica: </B> Consulte a documenta&ccedil;�o da classe {@link Rule} para mais detalhes.</I>
 * 
 * @author Ricardo Artur Staroski
 * @param <O> Tipo de dado do objeto que pode ou n�o atender a especifica&ccedil;�o desta interface.
 * @param <D> Tipo de dado da lista de detalhes que pode conter informa&ccedil;�es sobre o motivo de um objeto atender, ou n�o, a especifica&ccedil;�o desta
 *            interface.
 */
public interface Specification<O, D> {

    /**
     * Verifica se o objeto informado atende, ou n�o, a especifica&ccedil;�o desta interface.
     * 
     * @param object O objeto a ser verificado.
     * @param details Cole&ccedil;�o que pode conter os detalhes sobre o motivo de um objeto atender, ou n�o, a esta especifica&ccedil;�o.
     * @return <code>true</code> se o objeto atender a especifica&ccedil;�o e <code>false</code> caso contr�rio.
     */
    public boolean isSatisfiedBy(O object, Collection<D> details);
}
