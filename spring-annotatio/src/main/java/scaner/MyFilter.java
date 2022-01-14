package scaner;


import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 *  @See @CompontentScan
 *  @Description: 自定义注解需继承 {@link org.springframework.core.type.filter.TypeFilter}
 *  @author: zhao_yd
 *  @Date: 2020/12/18 9:48 上午
 *
 */

public class MyFilter implements TypeFilter {

    /**
     *
     * @param metadataReader
     * @param metadataReaderFactory
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        Class currClass = null;
        try {
            currClass = Class.forName(metadataReader.getClassMetadata().getClassName());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        boolean assignableFrom = currClass.isAssignableFrom(IService.class);
        return assignableFrom;
    }
}
