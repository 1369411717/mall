package priv.jesse.mall.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import priv.jesse.mall.entity.Product;
import priv.jesse.mall.utils.Helper;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.util.List;

public interface ProductService {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Product findById(int id);

    /**
     * 分页查询所有
     *
     * @param pageable
     * @return
     */
    Page<Product> findAll(Pageable pageable);

    /**
     * 按条件查询
     *
     * @param example
     * @return
     */
    List<Product> findAllExample(Example<Product> example);

    /**
     * 更新
     *
     * @param product
     * @return
     */
    void update(Product product);

    /**
     * 创建
     *
     * @param product
     * @return
     */
    int create(Product product);

    /**
     * 根据Id删除
     *
     * @param id
     * @return
     */
    void delById(int id);

}
