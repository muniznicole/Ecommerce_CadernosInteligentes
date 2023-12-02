package br.unitins.hello.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import br.unitins.hello.dto.ItemDTO;
import br.unitins.hello.dto.ItemResponseDTO;
import br.unitins.hello.model.Item;
import br.unitins.hello.model.TamanhoTipo;
import br.unitins.hello.repository.ItemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class ItemServiceImpl implements ItemService {

    @Inject
    ItemRepository itemRepository;

    private final String PATH_USER = System.getProperty("user.home") + "/quarkus/images/usuario/";


    private static final List<String> SUPPORTED_MIME_TYPES = 
    Arrays.asList("image/jpeg","image/jpg","image/png","image/gif");

    private static final int MAX_FILE_SIZE = 1024 * 1024 *10;
    @Override
    public ItemResponseDTO insert(ItemDTO dto) {

        Item novoItem = new Item();
        
        novoItem.setNomeItem(dto.nomeItem());
        novoItem.setDescricaoItem(dto.descricaoItem());
        novoItem.setPrecoItem(dto.precoItem());
        novoItem.setTamanho_tipo(dto.tamanho_tipo());
        novoItem.setNomeImagemItem(PATH_USER);
        itemRepository.persist(novoItem);

        return  ItemResponseDTO.valueOf(novoItem);

    }

    @Override
    public ItemResponseDTO update(ItemDTO dto, Long id) {

        Item item = itemRepository.findById(id);

        if(dto.nomeItem().equals("string")){
        } else {
            item.setNomeItem(dto.nomeItem());
        }

        if(dto.descricaoItem().equals("string")){
        } else {
            item.setDescricaoItem(dto.descricaoItem());
        }
        
        Double precoItem = dto.precoItem();
        if(precoItem != null && dto.precoItem() > 0.0){
        } else {
            item.setPrecoItem(dto.precoItem());
        }

        TamanhoTipo tamanho_tipo = dto.tamanho_tipo();
        if(tamanho_tipo != null){
        } else {
            item.setTamanho_tipo(dto.tamanho_tipo());
        }

        if(dto.imagemItem().equals("string")){
        } else {
            item.setNomeImagemItem(PATH_USER);
        }

        return  ItemResponseDTO.valueOf(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemResponseDTO findById(Long id) {
        Item novoItem = new Item();
        novoItem = itemRepository.findById(id);
        
        return  ItemResponseDTO.valueOf(novoItem);
    }

    @Override
    public List<ItemResponseDTO> findByNome(String nomeItem) {
        List<Item> list = itemRepository.findByNome(nomeItem);
        List<ItemResponseDTO> listdto= new ArrayList<>(); 
        for (Item saida : list) {
            listdto.add(ItemResponseDTO.valueOf(saida));
        }
        if(list == null)
            throw new NullPointerException("nenhum item encontrado");

        return listdto;
    }

    @Override
    public List<ItemResponseDTO> findByAll() {
        List<Item> list =  itemRepository.listAll();
        List<ItemResponseDTO> listdto= new ArrayList<>(); 
        for (Item saida : list) {
            listdto.add(ItemResponseDTO.valueOf(saida));
        }
        if(list == null)
            throw new NullPointerException("nenhum item encontrado");

        return listdto;        
    }

    @Override
    public String upload(String nomeArquivo, byte[] arquivo) throws IOException {
       verificarTamanhoImagem(arquivo); 
       verificarTipoImagem(nomeArquivo);

       Path diretorio = Paths.get(PATH_USER);
       Files.createDirectories(diretorio);

       String mimeType = Files.probeContentType(Paths.get(nomeArquivo));
       String extensao = mimeType.substring(mimeType.lastIndexOf("/")+1);   
       String novoNomeArquivo = UUID.randomUUID()+"."+extensao;

       Path filePath = diretorio.resolve(novoNomeArquivo);

       if(filePath.toFile().exists())
        throw new IOException("Nome de arquivo ja existe. Os alunos vão buscar uma melhor solução.");

        try(FileOutputStream fos = new FileOutputStream((filePath.toFile()))){
            fos.write(arquivo);
        }

        return filePath.toFile().getName();
    }

    @Override
    public File dowload(String nomeArquivo) {
        System.out.println("entrou");
        File file = new File(PATH_USER+nomeArquivo);
        return file;

    }

    private void verificarTamanhoImagem(byte[] arquivo) throws IOException{
        if(arquivo.length > MAX_FILE_SIZE)
            throw new IOException("Arquivo maior que 10mb.");
    }

    private void verificarTipoImagem(String nomeArquivo) throws IOException{
        String mimeType = Files.probeContentType(Paths.get(nomeArquivo));
        if(!SUPPORTED_MIME_TYPES.contains(mimeType))
            throw new IOException("Tipo de imagem não suportada.");
    }

    @Override
    public ItemResponseDTO updateImagemItem(Long id, String novoNomeImagem) {
        Item item = itemRepository.findById(id);
        item.setNomeImagemItem(novoNomeImagem);
        return ItemResponseDTO.valueOf(item);
    }
    
}
