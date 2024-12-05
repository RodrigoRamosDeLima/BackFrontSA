package com.senai.liquidsa;



import com.senai.liquidsa.dtos.req.CreateUsuarioDTO;
import com.senai.liquidsa.dtos.res.ShowUsuarioDTO;
import com.senai.liquidsa.entities.UsuarioEntity;
import com.senai.liquidsa.repositories.UsuarioRepository;
import com.senai.liquidsa.services.UsuarioService;
import com.senai.liquidsa.util.LoginUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private LoginUtil loginUtil;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriarUsuario() throws Exception {
        CreateUsuarioDTO dto = new CreateUsuarioDTO("Teste", "teste", "teste@email.com", "senha123", "bio");
        UsuarioEntity usuario = UsuarioEntity.builder()
                .nome("Teste")
                .login("teste")
                .email("teste@email.com")
                .senha("senha123")
                .bio("bio")
                .build();

        when(usuarioRepository.save(any(UsuarioEntity.class))).thenReturn(usuario);
        when(loginUtil.encryptPassword("senha123")).thenReturn("encrypted");

        ShowUsuarioDTO result = usuarioService.criarUsuario(dto);

        assertNotNull(result);
        assertEquals("Teste", result.getNome());
        verify(usuarioRepository, times(1)).save(any(UsuarioEntity.class));
    }
// @Test
// void testCadastroUsuarioCamposValidos() throws Exception {
//     // Arrange
//     CreateUsuarioDTO dto = new CreateUsuarioDTO("João", "joao123", "joao@email.com", "senha123", "Bio do João");
//     UsuarioEntity usuario = UsuarioEntity.builder()
//             .nome(dto.getNome())
//             .login(dto.getLogin())
//             .email(dto.getEmail())
//             .senha("encryptedSenha")
//             .bio(dto.getBio())
//             .build();

//     // Mockando a resposta do repositório
//     when(usuarioRepository.existsByEmail(dto.getEmail())).thenReturn(false);
//     when(usuarioRepository.save(any(UsuarioEntity.class))).thenReturn(usuario);
//     when(loginUtil.encryptPassword(dto.getSenha())).thenReturn("encryptedSenha");

//     // Act
//     ShowUsuarioDTO resultado = usuarioService.criarUsuario(dto);

//     // Assert
//     assertNotNull(resultado, "O resultado não deve ser nulo.");
//     assertEquals(dto.getNome(), resultado.getNome(), "O nome do usuário deve ser igual ao informado.");
//     assertEquals(dto.getEmail(), resultado.getEmail(), "O e-mail do usuário deve ser igual ao informado.");
//     verify(usuarioRepository, times(1)).save(any(UsuarioEntity.class));
// }
// @Test
// void testCadastroUsuarioEmailJaRegistrado() throws Exception {
//     // Arrange
//     CreateUsuarioDTO dto = new CreateUsuarioDTO("João", "joao123", "joao@email.com", "senha123", "Bio do João");

//     // Mockando a resposta para que o e-mail já esteja registrado
//     when(usuarioRepository.existsByEmail(dto.getEmail())).thenReturn(true);

//     // Act & Assert
//     Exception exception = assertThrows(RuntimeException.class, () -> usuarioService.criarUsuario(dto));

//     // Verificando a mensagem de erro
//     assertEquals("E-mail já registrado.", exception.getMessage(), "A mensagem de erro deve ser apropriada.");
//     verify(usuarioRepository, never()).save(any(UsuarioEntity.class));
// }
// @Test
// void testCadastroUsuarioCamposObrigatoriosEmBranco() throws Exception {
//     // Arrange
//     CreateUsuarioDTO dto = new CreateUsuarioDTO("", "", "", "", "");

//     // Act & Assert
//     Exception exception = assertThrows(RuntimeException.class, () -> usuarioService.criarUsuario(dto));

//     // Verificando a mensagem de erro
//     assertEquals("Todos os campos são obrigatórios.", exception.getMessage(), "A mensagem de erro deve indicar os campos ausentes.");
//     verify(usuarioRepository, never()).save(any(UsuarioEntity.class));
// }

    // @Test
    // void testBuscarUsuarioPorId() {
    //     UsuarioEntity usuario = UsuarioEntity.builder().id(1L).nome("Teste").build();
    //     when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

    //     ShowUsuarioDTO result = usuarioService.buscarUsuarioPorId(1L);

    //     assertNotNull(result);
    //     assertEquals("Teste", result.getNome());
    //     verify(usuarioRepository, times(1)).findById(1L);
    // }
}

