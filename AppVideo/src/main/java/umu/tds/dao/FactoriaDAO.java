package umu.tds.dao;

/**
 * Factoria abstracta DAO.
 */
public abstract class FactoriaDAO {
	
	public static final String DAO_TDS = "umu.tds.dao.TDSFactoriaDAO";

	private static FactoriaDAO unicaInstancia = null;
	
	/** 
	 * Crea un tipo de factoria DAO.
	 * Solo existe el tipo TDSFactoriaDAO
	 */
	public static FactoriaDAO getInstancia(String tipo) throws ReflectiveOperationException{
		if (unicaInstancia == null) {
			unicaInstancia=(FactoriaDAO) Class.forName(tipo).getDeclaredConstructor().newInstance();
		}
		return unicaInstancia;
	}
	
	public static FactoriaDAO getInstancia() throws ReflectiveOperationException {
		return getInstancia(FactoriaDAO.DAO_TDS);
	}

	protected FactoriaDAO (){}
	
	// Metodos factoria para obtener adaptadores
	public abstract UsuarioDAO getUsuarioDAO();	
	public abstract VideoDAO getVideoDAO();
	public abstract EtiquetaDAO getEtiquetaDAO();
	public abstract ListaVideoDAO getListaVideoDAO();
	
}
