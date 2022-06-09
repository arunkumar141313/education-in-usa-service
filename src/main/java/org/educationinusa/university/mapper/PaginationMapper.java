package org.educationinusa.university.mapper;

import org.educationinusa.university.model.PaginatedResponse;
import org.educationinusa.university.model.SortingOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class PaginationMapper<T> {

    public PaginatedResponse<T> pageToPaginationResponse(Page page) {
        PaginatedResponse<T> paginatedResponse = new PaginatedResponse<>();
        paginatedResponse.setPage(page.getNumber());
        paginatedResponse.setSize(page.getSize());
        paginatedResponse.setSort(getSortingOrderList(page.getSort()));
        paginatedResponse.setElements(page.getNumberOfElements());
        var totalPages = page.getTotalPages();
        paginatedResponse.setTotalPages(totalPages);
        paginatedResponse.setTotalElements(page.getTotalElements());
        return paginatedResponse;
    }

    private static List<SortingOrder> getSortingOrderList(Sort sort) {
        List<SortingOrder> sortingOrders = new ArrayList<>();
        var itr = sort.stream().iterator();
        while (itr.hasNext()) {
            var el = itr.next();
            sortingOrders.add(new SortingOrder(el.getDirection(), el.getProperty()));
        }
        return sortingOrders;
    }
}
