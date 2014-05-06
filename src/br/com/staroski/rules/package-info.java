/**
 * Neste pacote encontram-se classes que auxiliam na cria&ccedil;�o de regras que podem ser reutilizadas.<BR>
 * <BR>
 * <B><I>Para entender melhor, veja o exemplo abaixo:</I></B><BR>
 * <BR>
 * Uma <tt>Pessoa</tt> tem os seguintes atributos: <tt>nome</tt>, <tt>idade</tt> e <tt>sexo</tt>.<BR>
 * Para validar uma <tt>Pessoa</tt>, foram definidas as seguintes regras:<BR>
 * - O nome n�o pode ser <code>null</code> e deve come&ccedil;ar com uma letra mai�scula e ter uma ou mais letras min�sculas;<BR>
 * - A idade n�o pode ser negativa;<BR>
 * - O sexo s� pode ser <code>'M'</code> ou <code>'F'</code>.<BR>
 * <BR>
 * <B>Primeiro definimos a classe <tt>Pessoa</tt> conforme abaixo:</B>
 * 
 * <PRE>
 * class Pessoa {
 * 
 *     String nome;
 *     int idade;
 *     char sexo;
 * 
 *     Pessoa(String nome, int idade, char sexo) {
 *         this.nome = nome;
 *         this.idade = idade;
 *         this.sexo = sexo;
 *     }
 * }
 * </PRE>
 * 
 * <B>Agora criamos tr&ecirc;s especifica&ccedil;�es distintas para as regras que validam <tt>nome</tt>, <tt>idade</tt> e <tt>sexo</tt> da <tt>Pessoa</tt>.</B>
 * 
 * <PRE>
 * // Especifica&ccedil;�o da regra que valida o nome de uma Pessoa
 * class Nome implements Specification&lt;Pessoa, String&gt; {
 * 
 *     public boolean isSatisfiedBy(Pessoa pessoa, Collection&lt;String&gt; detalhes) {
 *         String nome = pessoa.nome;
 *         if (nome == null) {
 *             detalhes.add(&quot;Nome n�o pode ser null&quot;);
 *             return false;
 *         }
 *         if (!nome.matches(&quot;[A-Z]{1}[a-z]+&quot;)) {
 *             detalhes.add(&quot;Nome precisa come&ccedil;ar com letra maiuscula e ter pelo menos duas letras&quot;);
 *             return false;
 *         }
 *         return true;
 *     }
 * }
 * </PRE>
 * 
 * <PRE>
 * // Especifica&ccedil;�o da regra que valida a idade de Pessoa
 * class Idade implements Specification&lt;Pessoa, String&gt; {
 * 
 *     public boolean isSatisfiedBy(Pessoa pessoa, Collection&lt;String&gt; detalhes) {
 *         if (pessoa.idade &lt; 0) {
 *             detalhes.add(&quot;Idade n�o pode ser negativa&quot;);
 *             return false;
 *         }
 *         return true;
 *     }
 * }
 * </PRE>
 * 
 * <PRE>
 * // Especifica&ccedil;�o da regra que valida o sexo de uma Pessoa
 * class Sexo implements Specification&lt;Pessoa, String&gt; {
 * 
 *     public boolean isSatisfiedBy(Pessoa pessoa, Collection&lt;String&gt; detalhes) {
 *         switch (pessoa.sexo) {
 *             case 'M':
 *             case 'F':
 *                 return true;
 *             default:
 *                 detalhes.add(&quot;Sexo s� pode ser 'M' ou 'F'&quot;);
 *                 return false;
 *         }
 *     }
 * }
 * </PRE>
 * 
 * <B>Agora ja temos a classe <tt>Pessoa</tt> e as especifica&ccedil;�es das regras para <tt>nome</tt>, <tt>idade</tt> e <tt>sexo</tt> criadas.<BR>
 * Podemos ent�o utilizar a classe <tt>Rule</tt> para validar instancias de <tt>Pessoa</tt> de diversas formas, por exemplo:</B>
 * 
 * <PRE>
 * // instanciamos as regras a partir das especifica&ccedil;�es 
 * Rule&lt;Pessoa, String&gt; nome = Rule.from(new Nome());
 * Rule&lt;Pessoa, String&gt; idade = Rule.from(new Idade());
 * Rule&lt;Pessoa, String&gt; sexo = Rule.from(new Sexo());
 * 
 * // criamos uma pessoa com nome, idade e sexo validos
 * Pessoa pessoa = new Pessoa(&quot;Ricardo&quot;, 29, 'M');
 * if (nome.and(idade)
 *         .and(sexo)
 *         .isSatisfiedBy(pessoa)) {
 *     // o nome, idade e sexo da pessoa atendem as regras
 * }
 * 
 * // criamos uma pessoa com nome invalido, mas idade e sexo validos
 * pessoa = new Pessoa(&quot;RicArdO&quot;, 29, 'M');
 * Rule&lt;Pessoa, String&gt; regra = nome.and(idade)
 *                                  .and(sexo);
 * if (regra.not().isSatisfiedBy(pessoa)) {
 *     // apresentamos os detalhes
 *     for (String detalhe : regra.getDetails()) {
 *         System.out.println(detalhe);
 *     }
 * }
 * </PRE>
 */
package br.com.staroski.rules;
