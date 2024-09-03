import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    private HashMap<String, Bem> bensMap = new HashMap<>();
    private HashMap<String, Patrimonio> patrimoniosMap = new HashMap<>();
    private HashMap<String, Usuario> usuariosMap = new HashMap<>();
    private HashMap<String, RequisicaoDeManutencao> manutencoesMap = new HashMap<>();
    private ArrayList<Usuario> listausuarios = new ArrayList<>();
    private Usuario usuarioAutenticado;
    
    // Métodos para adicionar dados
    public void adicionarBem(Bem bem) {
        bensMap.put(bem.getId(), bem);
    }

    public void adicionarPatrimonio(Patrimonio patrimonio) {
        patrimoniosMap.put(patrimonio.getId(), patrimonio);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuariosMap.put(usuario.getId(), usuario);
        //adiciona o usuario na lista também, supostamente
        listaUsuarios.add(usuario);
    }

    public void adicionarRequisicaoDeManutencao(RequisicaoDeManutencao requisicao) {
        manutencoesMap.put(requisicao.getId(), requisicao);
    }

    // Métodos para buscar dados
    public Bem buscarBem(String id) {
        return bensMap.get(id);
    }

    public Patrimonio buscarPatrimonio(String id) {
        return patrimoniosMap.get(id);
    }

    public Usuario buscarUsuario(String id) {
        return usuariosMap.get(id);
    }

    public RequisicaoDeManutencao buscarRequisicao(String id) {
        return manutencoesMap.get(id);
    }

    // Métodos para listar todos os dados
    public ArrayList<Bem> listarBens() {
        return new ArrayList<>(bensMap.values());
    }

    public ArrayList<Patrimonio> listarPatrimonios() {
        return new ArrayList<>(patrimoniosMap.values());
    }

    public ArrayList<Usuario> listarUsuarios() {
        return new ArrayList<>(usuariosMap.values());
    }

    public ArrayList<RequisicaoDeManutencao> listarManutencoes() {
        return new ArrayList<>(manutencoesMap.values());
    }
//--------------------USUARIOS---------------------------------
    public Usuario getusuario(String id){
        return usuariosMap.get(id);
    }
    public void setUsuario(Usuario usuario){
        if(usuario != null && usuariosMap.containsKey(usuario.getId())){
            usuarioAutenticado = usuario;
        }
    }
    public Arraylist<Usuario> getUsuarios(){
        return listaUsuarios;
    }
    public Usuario getUsuarioAutenticado(){
        return usuarioAutenticado;
    }
    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null && !usuariosMap.containsKey(usuario.getId())) {
            usuariosMap.put(usuario.getId(), usuario);
            listaUsuarios.add(usuario);
        }
    }
    
    public void excluirUsuario(Usuario usuario) {
        if (usuario != null) {
            usuariosMap.remove(usuario.getId());
            listaUsuarios.remove(usuario);
            if (usuario.equals(usuarioAutenticado)) {
                usuarioAutenticado = null;
            }
        }
    }
}
    
