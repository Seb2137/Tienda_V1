/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service.impl;

import com.tienda.service.RegistroService;
import org.springframework.stereotype.Service;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private CorreoService correoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MessageSource messageSource;  //creado en semana 4...
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @Override
    public Model activar(Model model, String username, String clave) {
        Usuario usuario
                = usuarioService.getUsuarioForUsernameYPassword(username,
                        clave);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        } else {
            model.addAttribute(
                    "titulo",
                    messageSource.getMessage(
                            "registro.activar",
                            null, Locale.getDefault()));
        }
        model.addAttribute(
                "mensaje",
                messageSource.getMessage(
                        "registro.activar.error",
                        null, Locale.getDefault()));
    }
    return model ;

    @Override
    public void activar(Usuario usuario, MultipartFile imagenFile) {
        var codigo = new BCryptPasswordEncoder();
        usuario.setPassword(codigo.encode(usuario.getPassword()));

        if (!imagenFile.isEmpty()) {
            usuarioService.save(usuario, false);
            usuario.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "usuarios",
                            usuario.getIdUsuario()));
        }
        usuarioService.save(usuario, true);
    }
@Override
public Model crearUsuario(Model model, Usuario usuario)
    throws MessagingException {
    String mensaje;
    if (!usuarioService.
            existeUsuarioPorUsernameOCorreo(
                usuario.getUsername(),
                usuario.getCorreo())) {
        String clave = demeClave();
        usuario.setPassword(clave);
        usuario.setActivo(false);
        usuarioService.save(usuario, true);
        enviaCorreoActivar(usuario, clave);
        mensaje = String.format(
            messageSource.getMessage(
                "registro.mensaje.activacion.ok",
                null,
                Locale.getDefault()),
    
    
    
    
    
    
    
    
    
    
}
