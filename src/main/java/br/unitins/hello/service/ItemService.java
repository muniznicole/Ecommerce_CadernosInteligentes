package br.unitins.hello.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import br.unitins.hello.dto.ItemDTO;
import br.unitins.hello.dto.ItemResponseDTO;

public interface ItemService {

    public ItemResponseDTO insert(ItemDTO dto);

    public ItemResponseDTO update(ItemDTO dto, Long id);
    public ItemResponseDTO updateImagemItem(Long id, String novoNomeImagem);

    public void delete(Long id);

    public ItemResponseDTO findById(Long id);

    public List<ItemResponseDTO> findByNome(String nomeItem);

    public List<ItemResponseDTO> findByAll(); 
    
     String upload(String nomeArquivo, byte[] arquivo)throws IOException;
   
     File dowload(String nomeArquivo);

    }
