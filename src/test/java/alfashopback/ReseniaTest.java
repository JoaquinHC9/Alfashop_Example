package alfashopback;

public class ReseniaTest {

    /*private ReseniaController reseniaController;
    private ReseniaService reseniaService;

    @BeforeEach
    public void setUp() {
        reseniaService = mock(ReseniaService.class);

        reseniaController = new ReseniaController();
        reseniaController.setReseniaService(reseniaService);
    }

    @Test
    public void testGetAllResenias() {
        List<Resenia> resenias = new ArrayList<>();
        resenias.add(new Resenia());
        resenias.add(new Resenia());

        when(reseniaService.findAll()).thenReturn(resenias);

        List<Resenia> result = reseniaController.getAllResenias();

        assertEquals(resenias, result);
    }

    @Test
    public void testGetReseniaById() {
        Resenia resenia = new Resenia();
        resenia.setIdResenia(1);

        when(reseniaService.findById(1)).thenReturn(resenia);

        Resenia result = reseniaController.getReseniaById(1);

        assertEquals(resenia, result);
    }

    @Test
    public void testCreateResenia() {
        Resenia resenia = new Resenia();
        resenia.setIdResenia(1);

        when(reseniaService.save(resenia)).thenReturn(resenia);

        Resenia result = reseniaController.createResenia(resenia);

        assertEquals(resenia, result);
    }

    @Test
    public void testDeleteResenia() {
        assertDoesNotThrow(() -> reseniaController.deleteResenia(1));

        verify(reseniaService, times(1)).delete(1);
    }*/
}
