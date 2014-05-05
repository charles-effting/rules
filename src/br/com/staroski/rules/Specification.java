package br.com.staroski.rules;
import java.util.Collection;

/**
 * Interface que representa a especifica��o de uma regra para determinado tipo de dado.<BR>
 * A especifica��o pode fornecer detalhes sobre o motivo de um objeto atende-la ou n�o.<BR>
 * O crit�rio pra avaliar se um objeto atende ou n�o a uma especifica��o � realizado atrav�s da implementa��o do m�todo
 * {@link #isSatisfiedBy(Object, Collection)}.<BR>
 * <BR>
 * <I><B>Dica: </B> Consulte a documenta��o da classe {@link Rule} para mais detalhes.</I>
 * 
 * @author Ricardo Artur Staroski
 * @param <O> Tipo de dado do objeto que pode ou n�o atender a especifica��o desta interface.
 * @param <D> Tipo de dado da lista de detalhes que pode conter informa��es sobre o motivo de um objeto atender, ou n�o, a especifica��o desta
 *            interface.
 */
public interface Specification<O, D> {

    /**
     * Verifica se o objeto informado atende, ou n�o, a especifica��o desta interface.
     * 
     * @param object O objeto a ser verificado.
     * @param details Cole��o que pode conter os detalhes sobre o motivo de um objeto atender, ou n�o, a esta especifica��o.
     * @return <code>true</code> se o objeto atender a especifica��o e <code>false</code> caso contr�rio.
     */
    public boolean isSatisfiedBy(O object, Collection<D> details);
}