package umu.tds.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

import static java.util.stream.Collectors.toList;


import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.modelo.ListaVideo;
import umu.tds.modelo.Usuario;
import beans.Entidad;
import beans.Propiedad;

/**
 * 
 * Clase que implementa el Adaptador DAO concreto de Usuario para el tipo H2.
 * 
 */
public final class TDSUsuarioDAO implements UsuarioDAO {

	private static final String USUARIO = "Usuario";

	private static final String NOMBRE = "nombre";
	private static final String APELLIDOS = "apellidos";
	private static final String EMAIL = "email";
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final String FECHA_NACIMIENTO = "fechaNacimiento";
	private static final String IS_PREMIUM = "premium";
	private static final String LISTAS_VIDEO = "listasVideo";
	private static final String SEP_LISTAS_VID = " ";
	
	private ServicioPersistencia servPersistencia;
	private ListaVideoDAO adaptLV;
	private SimpleDateFormat dateFormat;

	public TDSUsuarioDAO() {
		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		try {
			adaptLV = FactoriaDAO.getInstancia().getListaVideoDAO();
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	private String listasVideoToString(List<ListaVideo> lista)  {
		
		StringJoiner sj = new StringJoiner(SEP_LISTAS_VID);
		lista.stream().forEach(l -> sj.add(String.valueOf(l.getId())));
		return sj.toString();
	}
	
	private List<ListaVideo> stringToListasVideo(String lista) {
		List<ListaVideo> lv = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(lista, SEP_LISTAS_VID);
		
		while (st.hasMoreTokens()) {
			lv.add(adaptLV.get(Integer.valueOf((String) st.nextElement())));
		}
		
		return lv;
	}

	private Usuario entidadToUsuario(Entidad eUsuario) {

		String nombre = servPersistencia.recuperarPropiedadEntidad(eUsuario, NOMBRE);
		String apellidos = servPersistencia.recuperarPropiedadEntidad(eUsuario, APELLIDOS);
		String email = servPersistencia.recuperarPropiedadEntidad(eUsuario, EMAIL);
		String login = servPersistencia.recuperarPropiedadEntidad(eUsuario, USERNAME);
		String password = servPersistencia.recuperarPropiedadEntidad(eUsuario, PASSWORD);
		String fechaNacimiento = servPersistencia.recuperarPropiedadEntidad(eUsuario, FECHA_NACIMIENTO);
		String premium = servPersistencia.recuperarPropiedadEntidad(eUsuario, IS_PREMIUM);
		String listaVideos = servPersistencia.recuperarPropiedadEntidad(eUsuario, LISTAS_VIDEO);
		
		//Parseamos la fecha: excep -> epoch
		Date d;
		try {
			d = dateFormat.parse(fechaNacimiento);
		} catch (ParseException e) {
			d = Date.from(Instant.EPOCH);
		}
		
		boolean p = Boolean.parseBoolean(premium);
		List<ListaVideo> lv = stringToListasVideo(listaVideos);
		Usuario usuario = new Usuario(nombre, apellidos, email, login, d, password, p, lv);
		usuario.setId(eUsuario.getId());

		return usuario;
	}

	private Entidad usuarioToEntidad(Usuario usuario) {
		Entidad eUsuario = new Entidad();
		eUsuario.setNombre(USUARIO);

		eUsuario.setPropiedades(new ArrayList<Propiedad>
		(Arrays.asList(new Propiedad(NOMBRE, usuario.getNombre()),
				new Propiedad(APELLIDOS, usuario.getApellidos()), new Propiedad(EMAIL, usuario.getEmail()),
				new Propiedad(USERNAME, usuario.getUsername()), new Propiedad(PASSWORD, usuario.getContraseña()),
				new Propiedad(FECHA_NACIMIENTO, dateFormat.format(usuario.getFechaNac())),
				new Propiedad(IS_PREMIUM, usuario.isPremium()+""),
				new Propiedad(LISTAS_VIDEO, listasVideoToString(usuario.getListasVideos()))
						
						)));
		return eUsuario;
	}

	public void create(Usuario usuario) {
		Entidad eUsuario = this.usuarioToEntidad(usuario);
		eUsuario = servPersistencia.registrarEntidad(eUsuario);
		usuario.setId(eUsuario.getId());
	}

	public boolean delete(Usuario usuario) {
		Entidad eUsuario;
		eUsuario = servPersistencia.recuperarEntidad(usuario.getId());

		return servPersistencia.borrarEntidad(eUsuario);
	}

	/**
	 * Permite que un Usuario modifique su perfil: password y email
	 */
	public void update(Usuario usuario) {
		Entidad eUsuario = servPersistencia.recuperarEntidad(usuario.getId());

		for (Propiedad prop : eUsuario.getPropiedades()) {
			if (prop.getNombre().equals(PASSWORD)) {
				prop.setValor(usuario.getContraseña());
			} else if (prop.getNombre().equals(EMAIL)) {
				prop.setValor(usuario.getEmail());
			} else if (prop.getNombre().equals(NOMBRE)) {
				prop.setValor(usuario.getNombre());
			} else if (prop.getNombre().equals(APELLIDOS)) {
				prop.setValor(usuario.getApellidos());
			} else if (prop.getNombre().equals(USERNAME)) {
				prop.setValor(usuario.getUsername());
			} else if (prop.getNombre().equals(FECHA_NACIMIENTO)) {
				prop.setValor(dateFormat.format(usuario.getFechaNac()));
			} else if (prop.getNombre().equals(IS_PREMIUM)) {
				prop.setValor(usuario.isPremium()+"");
			} else if (prop.getNombre().equals(LISTAS_VIDEO)) {
				prop.setValor(listasVideoToString(usuario.getListasVideos()));
			}
			servPersistencia.modificarPropiedad(prop);
		}
	}

	public Usuario get(int id) {
		
		Entidad eUsuario = servPersistencia.recuperarEntidad(id);
		return entidadToUsuario(eUsuario);
	}

	public List<Usuario> getAll() {
		List<Entidad> entidades = servPersistencia.recuperarEntidades(USUARIO);

		return entidades.stream()
						.map(e -> get(e.getId()))
						.collect(toList());
	}

}
