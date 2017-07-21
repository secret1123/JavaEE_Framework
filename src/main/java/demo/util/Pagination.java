package demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AnLu on
 * 2017/7/21 14:56.
 * JavaEE_Framework
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination<T extends Serializable> implements Serializable {
    private List<T> list;
    private String statement;
    private int pageSize = Constant.PAGE_SIZE;
    private int totalRows;
    private int totalPages;
    private int currentPage;
}
